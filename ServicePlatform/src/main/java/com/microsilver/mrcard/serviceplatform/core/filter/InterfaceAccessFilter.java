package com.microsilver.mrcard.serviceplatform.core.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.microsilver.mrcard.common.CryptoTools;
import com.microsilver.mrcard.serviceplatform.common.AnnotationUtil;
import com.microsilver.mrcard.serviceplatform.common.Consts;
import com.microsilver.mrcard.serviceplatform.dao.ImsSysGroupResourceMapper;
import com.microsilver.mrcard.serviceplatform.model.ImsSysGroupResource;
import com.microsilver.mrcard.serviceplatform.model.ImsSysGroupResourceExample;
import com.microsilver.mrcard.serviceplatform.model.enums.EEmployeeRole;

@Order(2)
@WebFilter(filterName = "interfaceAccessFilter", urlPatterns = "/api/*")
public class InterfaceAccessFilter implements Filter {

	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	private ImsSysGroupResourceMapper resourceMapper;
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException{
		String rsJson="";
		HttpServletRequest httpServletRequest = (HttpServletRequest)request;
		String requestURI = httpServletRequest.getRequestURI();
		requestURI = requestURI.replace("/ServicePlatform", "");
		Map<String,EEmployeeRole[]> accessURIFilter = AnnotationUtil.getAccessURIFilter();
		if (accessURIFilter.containsKey(requestURI)) {
			String token = httpServletRequest.getHeader("token");
			String appType = httpServletRequest.getHeader("apptype");
			String desKey = Consts.APP_TOKEN_DES_KEY;
			try {
				if (appType != null && appType.equals("5")) {
					// 小飞侠骑士版
					desKey = Consts.XIAO_FEI_XIA_DES_KEY;
				}
				String deToken = CryptoTools.decodeByDes(token, desKey);
				logger.debug("cer1={}",deToken);
				int index = deToken.lastIndexOf("+");
				String strCers = deToken.substring(0, index);
				String deCers = CryptoTools.decodeByDes(strCers.toString(), desKey);
				logger.debug("cer2={}",deCers);
				String[] strs = deCers.split("[+]");
				String identity = strs[0];
				if(identity!=null&&Integer.valueOf(identity)==21) {//如果是老板则拥有最高权限 可直接通过
					filterChain.doFilter(request, response);
					return;
				}
				String memberId = strs[1];
				ImsSysGroupResourceExample example = new ImsSysGroupResourceExample();
				example.createCriteria().andUidEqualTo(Integer.valueOf(memberId));
				List<ImsSysGroupResource> groupResource = resourceMapper.selectByExample(example);
				EEmployeeRole[] eEmployeeRoles = accessURIFilter.get(requestURI);
				for (ImsSysGroupResource res : groupResource) {
					for (EEmployeeRole role : eEmployeeRoles) {
						if(role.getValue()==res.getGroupId()) {
							filterChain.doFilter(request, response);
							return;
						}	
					}
				}
				rsJson = "{\"state\": 200,\"message\": \"您没有权限访问此接口！\",\"data\": []}";
				
			} catch (Exception e) {
				logger.error("token出现错误：{}",e.getMessage());
				rsJson = "{\"state\": 101,\"message\": \"错误的token！\",\"data\": []}";
			}
			response.setContentType("text/html; charset=UTF-8"); 
			PrintWriter out = response.getWriter();
			out.print(rsJson);
			out.close();
			return;
		}
		filterChain.doFilter(request, response);
	}
    @Override  
    public void init(FilterConfig config) throws ServletException {  
        ServletContext context = config.getServletContext();  
        ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(context);  
        resourceMapper =  ctx.getBean(ImsSysGroupResourceMapper.class); 
    }

	@Override
	public void destroy() {
		
	}  
}
