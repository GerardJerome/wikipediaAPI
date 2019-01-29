/*
 * Copyright 2017 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.appengine.demos.springboot;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.appengine.demos.springboot.service.WikipediaService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootExampleApplicationTests {

	 WikipediaService wiki = new WikipediaService();
  @Test
  public void contextLoads() {
  }
  
  @Test
  public void testGetTitle() throws IOException {
	  String test = wiki.getTitle("Test");
	  assertEquals( "Test", test);
  }

  @Test
  public void testGetContent() throws IOException {
	  String test = wiki.getContent("Test");
	  assertEquals(true, test.startsWith("{{"));
  }
}
