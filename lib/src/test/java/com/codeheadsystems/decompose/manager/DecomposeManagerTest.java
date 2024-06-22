package com.codeheadsystems.decompose.manager;

import static com.codeheadsystems.test.FixtureHelper.getFixture;
import static org.assertj.core.api.Assertions.assertThat;

import com.codeheadsystems.decompose.factory.ObjectMapperFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class DecomposeManagerTest {

  private DecomposeManager decomposeManager;

  @BeforeEach
  void setUp() {
    decomposeManager = new DecomposeManager(new ObjectMapperFactory().generate());
  }

  @Test
  void testDecomposeManager() {
    assertThat(decomposeManager).isNotNull();
  }

  @Test
  void testDecompose() {
    assertThat(decomposeManager.decompose(getFixture("simple_tree.json")))
        .isNotNull();
  }

}