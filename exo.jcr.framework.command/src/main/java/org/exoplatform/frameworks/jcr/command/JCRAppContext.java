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
package org.exoplatform.frameworks.jcr.command;

import org.apache.commons.chain.Context;

import javax.jcr.LoginException;
import javax.jcr.NoSuchWorkspaceException;
import javax.jcr.RepositoryException;
import javax.jcr.Session;

/**
 * Created by The eXo Platform SAS .
 * 
 * @author <a href="mailto:gennady.azarenkov@exoplatform.com">Gennady Azarenkov</a>
 * @version $Id: JCRAppContext.java 5800 2006-05-28 18:03:31Z geaz $
 */

public interface JCRAppContext extends Context
{

   /**
    * Change current workspace name.
    * 
    * @param workspaceName
    */
   void setCurrentWorkspace(String workspaceName);

   /**
    * Return Session of the context.
    * 
    * @return the session
    * @throws LoginException
    * @throws NoSuchWorkspaceException
    * @throws RepositoryException
    */
   Session getSession() throws LoginException, NoSuchWorkspaceException, RepositoryException;
}
