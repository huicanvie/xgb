package cn.tomoya.exception;

import cn.tomoya.config.yml.SiteConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * xgb.
 * Copyright (c) 2016, All Rights Reserved.
 * http://tomoya.cn
 */
@ControllerAdvice
public class GlobalExceptionHandler {

  private Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

  @Autowired
  private SiteConfig siteConfig;

  private HttpStatus getStatus(HttpServletRequest request) {
    Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
    if (statusCode == null) {
      return HttpStatus.INTERNAL_SERVER_ERROR;
    }
    return HttpStatus.valueOf(statusCode);
  }

  /**
   * 错误页面统一处理
   *
   * @param request
   * @param e
   * @return
   * @throws Exception
   */
  @ExceptionHandler(value = Exception.class)
  public ModelAndView defaultErrorHandler(HttpServletRequest request, Exception e) throws Exception {
    e.printStackTrace();
    ModelAndView mav = new ModelAndView();
    mav.addObject("exception", e);
    mav.addObject("errorCode", getStatus(request));
    mav.setViewName(siteConfig.getTheme() + "/front/error");
    return mav;
  }

  /**
   * 接口错误统一处理
   *
   * @param e
   * @return
   * @throws Exception
   */
  @ExceptionHandler(value = ApiException.class)
  @ResponseBody
  public Result<?> jsonErrorHandler(ApiException e) throws Exception {
    Result<?> result = new Result<>();
    result.setCode(e.getCode());
    result.setDescription(e.getMessage());
    return result;
  }
}