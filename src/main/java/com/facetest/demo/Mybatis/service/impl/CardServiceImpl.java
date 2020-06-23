package com.facetest.demo.Mybatis.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.facetest.demo.Mybatis.bean.Card;
import com.facetest.demo.Mybatis.mapper.CardMapper;
import com.facetest.demo.Mybatis.service.CardService;
import org.springframework.stereotype.Service;

@Service
public class CardServiceImpl extends ServiceImpl<CardMapper, Card> implements CardService {
}
