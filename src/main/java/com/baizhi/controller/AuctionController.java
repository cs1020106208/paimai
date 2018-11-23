package com.baizhi.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.baizhi.entity.Auction;
import com.baizhi.service.AuctionService;

@Controller
@RequestMapping("/auction")
public class AuctionController {

	@Autowired
	private AuctionService auctionService;
	
	
	//查找全部
	@RequestMapping("/selectAllAuction")
	public String selectAllAuction(Auction auction,HttpServletRequest request){
		//user=(User) session.get("user");
		List<Auction> auctionList= auctionService.selectAllAuction(auction);
	   request.setAttribute("auctionList", auctionList);
		return "main";
	}
	
	//删除
	@RequestMapping("/deleteAuction")
	public String deleteAuction(int auction_id){
		auctionService.deleteAuction(auction_id);
		return "redirect:/auction/selectAllAuction.do";
	}
	
	//查找一个
	@RequestMapping("/selectOneAuction")
	public String selectOneAuction(int auction_id,HttpServletRequest request){
		Auction auction=auctionService.selectOneAuctioin(auction_id);
		 request.setAttribute("auction", auction);
		 System.out.println(auction);
		return "updateProduct";
		
	}
	
	//修改
	@RequestMapping("/updateAuction")
	public String updateAuction(Auction auction,HttpServletRequest request,MultipartFile tupian) throws Exception{
		if(!"".equals(tupian.getOriginalFilename())){
			
			String realPath=request.getRealPath("/images");
			//new Date().getTime()+"_"+
			String newFileName=tupian.getOriginalFilename();
			tupian.transferTo(new File(realPath+"/"+newFileName));
			auction.setAuction_pic(newFileName);
			System.out.println(auction+"1111111111111111修改1");

		}
		System.out.println(auction);
		auctionService.updateAuction(auction);
		return "redirect:/auction/selectAllAuction.do";
	}
	
	//添加
	@RequestMapping("/insertAuction")
	public String insertAuction(Auction auction,MultipartFile tupian,HttpServletRequest request) throws IllegalStateException, IOException{
		
	if(!"".equals(tupian.getOriginalFilename())){
			
			String realPath=request.getRealPath("/images");
			//new Date().getTime()+"_"+
			String newFileName=tupian.getOriginalFilename();
			tupian.transferTo(new File(realPath+"/"+newFileName));
			auction.setAuction_pic(newFileName);
			System.out.println(auction+"添加111111111111111111");

		}
		
		auctionService.insertAuction(auction);
		return "redirect:/auction/selectAllAuction.do";
		
	}
	

	
}