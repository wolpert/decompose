package com.codeheadsystems.test;

import static org.assertj.core.api.Assertions.assertThat;

import com.codeheadsystems.decompose.factory.ObjectMapperFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestCodeWorks {

  private ObjectMapper objectMapper;

  @BeforeEach
  void setUp() {
    objectMapper = new ObjectMapperFactory().generate();
  }

  @Test
  void fixtures() {
    assertThat(FixtureHelper.getFixture("simple_tree.json")).isNotNull();
    assertThat(FixtureHelper.getFixture("simple_tree.yml")).isNotNull();
  }

  @Test
  void jsonWorks() throws JsonProcessingException {
    assertThat(objectMapper.readValue(FixtureHelper.getFixture("simple_tree.json"), ObjectNode.class))
        .isNotNull();
  }

  @Test
  void yamlWorks() throws JsonProcessingException {
    assertThat(objectMapper.readValue(FixtureHelper.getFixture("simple_tree.yml"), ObjectNode.class))
        .isNotNull();
  }

}
