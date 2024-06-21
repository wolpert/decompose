package com.codeheadsystems.decompose;

import javax.inject.Inject;
import javax.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Singleton
public class DecomposeManager {

  private static final Logger log = LoggerFactory.getLogger(DecomposeManager.class);

  @Inject
  public DecomposeManager() {
    log.info("DecomposeManager()");
  }

}
