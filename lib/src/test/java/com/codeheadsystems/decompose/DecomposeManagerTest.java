package com.codeheadsystems.decompose;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class DecomposeManagerTest {

  @InjectMocks private DecomposeManager decomposeManager;

  @Test
  void testDecomposeManager() {
    assertThat(decomposeManager).isNotNull();
  }

}