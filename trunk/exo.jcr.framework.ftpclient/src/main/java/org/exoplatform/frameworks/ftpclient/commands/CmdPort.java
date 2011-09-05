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
package org.exoplatform.frameworks.ftpclient.commands;

import org.exoplatform.frameworks.ftpclient.FtpConst;
import org.exoplatform.services.log.ExoLogger;
import org.exoplatform.services.log.Log;

/**
 * Created by The eXo Platform SAS .
 * 
 * @author Vitaly Guly
 * @version $Id: $
 */

public class CmdPort extends FtpCommandImpl
{

   private static Log log = ExoLogger.getLogger("exo.jcr.framework.command.CmdPort");

   protected String host;

   protected int port;

   public CmdPort(String host, int port)
   {
      this.host = host;
      this.port = port;
   }

   public int execute()
   {
      try
      {

         // this "IF" for tests only. try to get reply 500
         if (host == null)
         {
            sendCommand(FtpConst.Commands.CMD_PORT);
            return getReply();
         }

         sendCommand(String.format("%s %s,%d,%d", FtpConst.Commands.CMD_PORT, host, port / 256, port % 256).replace(
            '.', ','));
         return getReply();
      }
      catch (Exception exc)
      {
         log.info(FtpConst.EXC_MSG + exc.getMessage(), exc);
      }
      return -1;
   }

}
