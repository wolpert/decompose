package com.codeheadsystems.decompose.manager;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Singleton
public class DecomposeManager {

  private static final Logger log = LoggerFactory.getLogger(DecomposeManager.class);

  private final ObjectMapper objectMapper;

  @Inject
  public DecomposeManager(final ObjectMapper objectMapper) {
    this.objectMapper = objectMapper;
    log.info("DecomposeManager({})", objectMapper);
  }

  public ObjectNode decompose(String json) {
    try {
      return (ObjectNode) objectMapper.readTree(json);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

}
