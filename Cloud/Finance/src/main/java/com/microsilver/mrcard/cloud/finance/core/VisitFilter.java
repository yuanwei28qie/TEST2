package com.microsilver.mrcard.cloud.finance.core;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.web.filter.OncePerRequestFilter;

import com.microsilver.mrcard.common.Utils;



/**
 * 
 * @Name com.microsilver.mrcard.cloud.finance.core.VisitFilter
 * @Description 
 * 
 * @Author bruce
 * @Version 2017年8月10日 下午1:50:38
 * @Copyright Micro Silver
 *
 */
@Order(1)
@WebFilter(filterName = "visitFilter", urlPatterns = "/finance/*")
public class VisitFilter extends OncePerRequestFilter{
	private final static Logger logger = LoggerFactory.getLogger(VisitFilter.class);
	
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		boolean isEffective = false;
		String clientIp = Utils.getIpAddress(request);
		String ips=Consts.EFFECTIVE_IP;
		String[] clientIPs = ips.split(",");
		for (String s : clientIPs) {
			if (s.equals(clientIp)) {
				isEffective = true;
				break;
			}
		}
		if (!isEffective) {
			logger.info("未授权的访问:{}",clientIp);
			String rsJson = "{\"state\": 100,\"message\": \"非法请求！\",\"data\": []}";
			response.setContentType("text/html; charset=UTF-8"); 
			PrintWriter out = response.getWriter();
			out.print(rsJson);
		} else {
			filterChain.doFilter(request, response);
		}
	}
}
