/*
 * Copyright (C) 2018 Red Hat inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.fabric8.knative.test;

import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.knative.api.client.KnativeClient;
import io.fabric8.knative.mock.KnativeMockServer;
import io.fabric8.kubernetes.client.KubernetesClient;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class AdaptTest {

  private KnativeMockServer mock = new KnativeMockServer();

  @Before
  public void setUp() {
    mock.init();
  }

  @After
  public void tearDown() throws IOException {
    mock.destroy();
  }


  @Test
  public void testAdapt() {
    KnativeClient sc = mock.createKnative();
    KubernetesClient kc = new DefaultKubernetesClient(sc.getConfiguration());
    Assert.assertNotNull(kc.adapt(KnativeClient.class));
  }
}
