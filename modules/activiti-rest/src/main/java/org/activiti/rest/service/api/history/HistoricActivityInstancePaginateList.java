/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.activiti.rest.service.api.history;

import java.util.ArrayList;
import java.util.List;

import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.rest.common.api.AbstractPaginateList;
import org.activiti.rest.service.api.RestResponseFactory;

/**
 * @author Tijs Rademakers
 */
public class HistoricActivityInstancePaginateList extends AbstractPaginateList {
  
  protected RestResponseFactory restResponseFactory;
  protected String serverRootUrl;
  
  public HistoricActivityInstancePaginateList(RestResponseFactory restResponseFactory, String serverRootUrl) {
    this.restResponseFactory = restResponseFactory;
    this.serverRootUrl = serverRootUrl;
  }
  
  @SuppressWarnings("rawtypes")
  @Override
  protected List processList(List list) {
    List<HistoricActivityInstanceResponse> responseList = new ArrayList<HistoricActivityInstanceResponse>();
    for (Object instance : list) {
      responseList.add(restResponseFactory.createHistoricActivityInstanceResponse(
          (HistoricActivityInstance) instance, serverRootUrl));
    }
    return responseList;
  }
}
