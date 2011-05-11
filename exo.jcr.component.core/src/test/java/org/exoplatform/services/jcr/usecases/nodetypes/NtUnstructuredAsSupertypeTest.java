/*
 * Copyright (C) 2009 eXo Platform SAS.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.exoplatform.services.jcr.usecases.nodetypes;

import org.exoplatform.services.jcr.usecases.BaseUsecasesTest;

import javax.jcr.Node;

/**
 * @author <a href="mailto:Sergey.Kabashnyuk@gmail.com">Sergey Kabashnyuk</a>
 * @version $Id: NtUnstructuredAsSupertypeTest.java 11907 2008-03-13 15:36:21Z ksm $
 */
public class NtUnstructuredAsSupertypeTest extends BaseUsecasesTest
{

   public void testMultiValue() throws Exception
   {
      Node rootNode = session.getRootNode();
      Node tNode = rootNode.addNode("testNode", "exojcrtest:sub1");
      tNode.setProperty("multi", new String[]{"v1", "v2"});
      tNode.setProperty("multi", new String[]{"v1"});
      rootNode.save();

   }

   public void testSingleValue() throws Exception
   {
      Node rootNode = session.getRootNode();
      Node tNode = rootNode.addNode("testNode", "exojcrtest:sub1");
      tNode.setProperty("single", "v1");
      rootNode.save();
   }

   public void testSingleandMultiValue() throws Exception
   {
      Node rootNode = session.getRootNode();
      Node tNode = rootNode.addNode("testNode", "exojcrtest:sub1");
      tNode.setProperty("single", "v1");
      tNode.setProperty("multi", new String[]{"v1", "v2"});
      tNode.setProperty("multi", new String[]{"v1"});
      rootNode.save();
   }

}
