package com.codeheadsystems.test;

import java.io.IOException;
import java.io.InputStream;

public class FixtureHelper {

  public static String getFixture(String name) {
    try (InputStream inputStream = FixtureHelper.class.getResourceAsStream("/fixtures/" + name)) {
      if (inputStream == null) {
        throw new RuntimeException("Fixture not found: " + name);
      }
      return new String(inputStream.readAllBytes());
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

}
