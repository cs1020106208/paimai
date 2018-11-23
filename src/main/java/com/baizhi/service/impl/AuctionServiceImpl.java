package com.baizhi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baizhi.dao.AuctionDao;
import com.baizhi.entity.Auction;
import com.baizhi.service.AuctionService;

@Service("AuctionService")
public class AuctionServiceImpl implements AuctionService {
	@Autowired	
private AuctionDao auctionDao;

public void setAuctionDao(AuctionDao auctionDao) {
	this.auctionDao = auctionDao;
}

	public AuctionDao getAuctionDao() {
	return auctionDao;
}

	//查找全部
	@Override
	public List<Auction> selectAllAuction(Auction auction) {
		return auctionDao.selectAllAuction(auction);
				
	}

	/*@Override
	public List<Auction> selectAllAuction() {
		return auctionDao.selectAllAuction();
	}*/

	//查找一个
	@Override
	public Auction selectOneAuctioin(int id) {
		Auction auction=auctionDao.selectOneAuction(id);
		return auction;
	}
	
	//添加
	@Override
	public void insertAuction(Auction auction) {
		auctionDao.insertAuction(auction);
	}

	//删除
	@Override
	public void deleteAuction(int id) {
			auctionDao.deleteAuction(id);
	}
	
	//修改
	@Override
	public void updateAuction(Auction auction) {
			auctionDao.updateAuction(auction);
	}


	
}
