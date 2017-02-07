/* Copyright 2016 Google Inc. All Rights Reserved.
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
package com.vidyo_io.server;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Logger;
import io.vidyo.util.GenerateToken;

public class VidyoIOTokenServlet extends HttpServlet {
    private static final Logger log = Logger.getLogger(VidyoIOTokenServlet.class.getName());
    
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
          throws IOException {
        String userName = req.getParameter("user_id");
        String token;
        String appID = getServletConfig().getInitParameter("appID");
        String key = getServletConfig().getInitParameter("key");
        String vCard = "";
        String expiresInSeconds = "10000";

        token = GenerateToken.generateProvisionToken(key, userName + "@" + appID, expiresInSeconds, vCard);

        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setContentType("application/json");
        resp.getWriter().println("{\"token\":\"" + token + "\"}");
    }
}

