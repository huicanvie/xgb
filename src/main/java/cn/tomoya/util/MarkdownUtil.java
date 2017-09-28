package cn.tomoya.util;

import org.pegdown.Extensions;
import org.pegdown.PegDownProcessor;

/**
 * Created by tomoya.
 * Copyright (c) 2016, All Rights Reserved.
 * http://tomoya.cn
 */
public class MarkdownUtil {

  private final static PegDownProcessor md = new PegDownProcessor(
      Extensions.ALL_OPTIONALS | Extensions.ALL_WITH_OPTIONALS);

  public static String pegDown(String content) {
    return md.markdownToHtml(content == null ? "" : content);
  }

}
