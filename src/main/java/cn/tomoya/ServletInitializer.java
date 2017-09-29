package cn.tomoya;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * xgb.
 * Copyright (c) 2016, All Rights Reserved.
 * http://tomoya.cn
 */
public class ServletInitializer extends SpringBootServletInitializer {

  @Override
  protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
    return application.sources(XgbbbsApplication.class);
  }

}