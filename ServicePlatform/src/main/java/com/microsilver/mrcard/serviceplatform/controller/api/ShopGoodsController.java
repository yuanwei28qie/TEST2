package com.microsilver.mrcard.serviceplatform.controller.api;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.microsilver.mrcard.serviceplatform.common.Consts;
import com.microsilver.mrcard.serviceplatform.common.Utils;
import com.microsilver.mrcard.serviceplatform.controller.BaseController;
import com.microsilver.mrcard.serviceplatform.core.exception.BusinessException;
import com.microsilver.mrcard.serviceplatform.dto.RespBaseDto;
import com.microsilver.mrcard.serviceplatform.dto.ShopGoodsDto;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopCategory;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopGoods;
import com.microsilver.mrcard.serviceplatform.model.enums.EWarning;
import com.microsilver.mrcard.serviceplatform.service.ImsEweiShopCategorySmpl;
import com.microsilver.mrcard.serviceplatform.service.ImsEweiShopGoodsSmpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value = "/api/ShopGoods", description = "商品相关接口")
@RestController
@RequestMapping("/api/ShopGoods")
public class ShopGoodsController extends BaseController {

	@Resource
	private ImsEweiShopGoodsSmpl eweiShopGoodsSmpl;
	@Resource
	private ImsEweiShopCategorySmpl categorySmpl;
	
	@ApiImplicitParams({
		@ApiImplicitParam(name="id",value="商品id(更新时需要传)"),
		@ApiImplicitParam(name="merchid",value="商户ID"),
		@ApiImplicitParam(name="uniacid",value="商户区域ID"),
		@ApiImplicitParam(name="title",value="商品名称"),
		@ApiImplicitParam(name="unit",value="商品单位"),
		@ApiImplicitParam(name="pcate",value="一级分类"),
		@ApiImplicitParam(name="ccate",value="二级分类"),
		@ApiImplicitParam(name="marketprice",value="商品价格"),
		@ApiImplicitParam(name="total",value="商品库存"),
		@ApiImplicitParam(name="weight",value="商品重量"),
		@ApiImplicitParam(name="description",value="商品描述"),
		@ApiImplicitParam(name="thumb",value="商品缩略图"),
		@ApiImplicitParam(name="thumbUrl",value="商品详情图片")
	})
	@ApiOperation(value = "添加/更新商品", httpMethod = "POST")
	@RequestMapping("mergeGoods")
	public RespBaseDto<String> mergeGoods(ShopGoodsDto goodsDto){
		RespBaseDto<String> dto = new RespBaseDto<>();
		try {
			ImsEweiShopGoods goods = new ImsEweiShopGoods();
			if(goodsDto.getThumbUrl()!=null&&!goodsDto.getThumbUrl().equals("")){
				String url = Utils.phpSerialize(goodsDto.getThumbUrl().split(","), "utf-8");
				goodsDto.setThumbUrl(url);				
			}
			goods.setUpdatetime(Utils.getCurrentTime());
			if(goodsDto.getId()!=null){
				if(goodsDto.getStatus()==Consts.GOODS_STATUS_CHECKEDFAILED){
					goodsDto.setStatus(Consts.GOODS_STATUS_UNDERCARRIAGE);					
				}
			}else{
				goodsDto.setChecked(Consts.GOODS_CHECKED_AUDIT);
				goods.setCreatetime(Utils.getCurrentTime());				
			}
			goodsDto.setProductprice(goodsDto.getMarketprice());
			BeanUtils.copyProperties(goods, goodsDto);
			eweiShopGoodsSmpl.mergeGoods(goods);
			dto.setMessage("OK");
		} catch (Exception e) {
			e.printStackTrace();
			dto.setMessage(EWarning.Unknown.getName());
			dto.setState(EWarning.Unknown.getValue());
		}
		return dto;
	}
	
	@ApiOperation(value = "获取商品分类", httpMethod = "POST")
	@RequestMapping("getGoodsCategory")
	public RespBaseDto<Map<String, List<ImsEweiShopCategory>>> getGoodsCategory(){
		RespBaseDto<Map<String, List<ImsEweiShopCategory>>> dto = new RespBaseDto<>();
		try {
			Map<String, List<ImsEweiShopCategory>> allCategory = categorySmpl.getAllCategory();		
			dto.setData(allCategory);
		} catch (Exception e) {
			e.printStackTrace();
			dto.setMessage(EWarning.Unknown.getName());
			dto.setState(EWarning.Unknown.getValue());
		}
		return dto;
	}
	
	@ApiOperation(value = "获取商品列表", httpMethod = "POST")
	@ApiImplicitParams({
		@ApiImplicitParam(name="merchId",value="商户ID"),
		@ApiImplicitParam(name="type",value="要获取的列表类型1.出售中2.审核中3.已售罄4.仓库中5.回收站"),
		@ApiImplicitParam(name="pageNum",value="当前页码")
	})
	@RequestMapping("getGoodsList")
	public RespBaseDto<List<ShopGoodsDto>> getGoodsList(Integer merchId,Integer type,@RequestParam(defaultValue="1")Integer pageNum){
		RespBaseDto<List<ShopGoodsDto>> dto = new RespBaseDto<>();
		try {
			List<ShopGoodsDto>shopGoodsList = eweiShopGoodsSmpl.getGoodsList(merchId,type,pageNum);		
			dto.setData(shopGoodsList);
		} catch (BusinessException e) {
			e.printStackTrace();
			dto.setMessage(e.getWarning().getName());
			dto.setState(e.getWarning().getValue());
		} catch (Exception e) {
			e.printStackTrace();
			dto.setMessage(EWarning.Unknown.getName());
			dto.setState(EWarning.Unknown.getValue());
		} 
		return dto;
	}
	
	@ApiOperation(value = "查看是否有商品未审核通过", httpMethod = "POST")
	@ApiImplicitParams({
		@ApiImplicitParam(name="merchId",value="商户ID")})
	@RequestMapping("getCheckFailedGoods")
	public RespBaseDto<Integer> getCheckFailedGoods(Integer merchId){
		RespBaseDto<Integer> dto = new RespBaseDto<>();
		try {
			List<ImsEweiShopGoods> shopGoodsList = eweiShopGoodsSmpl.getCheckFailedGoods(merchId);		
			dto.setData(shopGoodsList.size());
		} catch (Exception e) {
			e.printStackTrace();
			dto.setMessage(EWarning.Unknown.getName());
			dto.setState(EWarning.Unknown.getValue());
		}
		return dto;
	}
	
	@ApiOperation(value = "商品上/下架", httpMethod = "POST")
	@ApiImplicitParams({
		@ApiImplicitParam(name="id",value="商品ID"),
		@ApiImplicitParam(name="status",value="状态 0.下架 1.上架")
		})
	@RequestMapping("changeGoodsStatus")
	public RespBaseDto<String> changeGoodsStatus(Integer id,byte status){
		RespBaseDto<String> dto = new RespBaseDto<>();
		try {
			ImsEweiShopGoods goods = new ImsEweiShopGoods();
			goods.setId(id);
			goods.setStatus(status);
			int result = eweiShopGoodsSmpl.changeGoodsStatus(goods);	
			if(result>0)
			dto.setData("OK");
		} catch (Exception e) {
			e.printStackTrace();
			dto.setMessage(EWarning.Unknown.getName());
			dto.setState(EWarning.Unknown.getValue());
		}
		return dto;
	}
	
	@ApiOperation(value = "根据商品id获取商品", httpMethod = "POST")
	@ApiImplicitParams({
		@ApiImplicitParam(name="id",value="商品ID")
		})
	@RequestMapping("getGoodsById")
	public RespBaseDto<ShopGoodsDto> getGoodsById(Integer id){
		RespBaseDto<ShopGoodsDto> dto = new RespBaseDto<>();
		try {	
			ShopGoodsDto goodsDto = eweiShopGoodsSmpl.getGoodsById(id);	
			dto.setData(goodsDto);
		} catch (Exception e) {
			e.printStackTrace();
			dto.setMessage(EWarning.Unknown.getName());
			dto.setState(EWarning.Unknown.getValue());
		}
		return dto;
	}
	
	@ApiOperation(value = "恢复/删除商品(逻辑删除)", httpMethod = "POST")
	@ApiImplicitParams({
		@ApiImplicitParam(name="id",value="商品ID"),
		@ApiImplicitParam(name="deleted",value="状态0.恢复 1.删除")
		})
	@RequestMapping("isDeleteGoodsById")
	public RespBaseDto<String> isDeleteGoodsById(Integer id,byte deleted){
		RespBaseDto<String> dto = new RespBaseDto<>();
		try {
			ImsEweiShopGoods goods = new ImsEweiShopGoods();
			goods.setId(id);
			goods.setDeleted(deleted);
			int result = eweiShopGoodsSmpl.changeGoodsStatus(goods);	
			if(result>0)
			dto.setData("OK");
		} catch (Exception e) {
			e.printStackTrace();
			dto.setMessage(EWarning.Unknown.getName());
			dto.setState(EWarning.Unknown.getValue());
		}
		return dto;
	}
	
	@ApiOperation(value = "从回收站彻底删除", httpMethod = "POST")
	@ApiImplicitParams({
		@ApiImplicitParam(name="id",value="商品ID"),
		@ApiImplicitParam(name="deleted",value="状态0.恢复 1.删除")
		})
	@RequestMapping("deleteGoodsById")
	public RespBaseDto<String> deleteGoodsFromRecycleBin(Integer id){
		RespBaseDto<String> dto = new RespBaseDto<>();
		try {
			int result = eweiShopGoodsSmpl.deleteGoodsById(id);	
			if(result>0)
			dto.setData("OK");
		} catch (Exception e) {
			e.printStackTrace();
			dto.setMessage(EWarning.Unknown.getName());
			dto.setState(EWarning.Unknown.getValue());
		}
		return dto;
	}
}
