package com.codeheadsystems.decompose.factory;

import static org.assertj.core.api.Assertions.assertThat;

import com.codeheadsystems.test.FixtureHelper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Validates that the object mapper works as expected as delivered by the factory.
 */
class ObjectMapperFactoryTest {

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
    final ObjectNode node = objectMapper.readValue(FixtureHelper.getFixture("simple_tree.json"), ObjectNode.class);
    validateSimpleTree(node);
  }

  @Test
  void yamlWorks() throws JsonProcessingException {
    final ObjectNode node = objectMapper.readValue(FixtureHelper.getFixture("simple_tree.yml"), ObjectNode.class);
    validateSimpleTree(node);
  }

  private void validateSimpleTree(final ObjectNode node) {
    assertThat(node)
        .isNotNull();
    ObjectNode parent = (ObjectNode) node.get("a");
    assertThat(parent)
        .isNotNull()
        .hasSize(2);
    assertThat(parent.get("b")).isNotNull();
    assertThat(parent.get("c")).isNotNull();
    assertThat(parent.get("d")).isNull();
  }
}