package com.factual;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.common.collect.Lists;



/**
 * Represents the response from running a Crosswalk lookup against Factual.
 *
 * @author aaron
 */
public class CrosswalkResponse extends Response {
  private final List<Crosswalk> crosswalks = Lists.newArrayList();


  /**
   * Constructor, parses from a JSON response String.
   * 
   * @param json the JSON response String returned by Factual.
   */
  public CrosswalkResponse(String json) {
    try {
      JSONObject rootJsonObj = new JSONObject(json);
      Response.withMeta(this, rootJsonObj);
      parseCrosswalks(rootJsonObj.getJSONObject("response").getJSONArray("data"));
    } catch (JSONException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Returns the ordered collection of Crosswalks represented by this response.
   * 
   * @return the ordered collection of Crosswalks represented by this response.
   */
  public List<Crosswalk> getCrosswalks() {
    return crosswalks;
  }

  private void parseCrosswalks(JSONArray arr) throws JSONException {
    for(int i=0; i<arr.length(); i++) {
      crosswalks.add(crosswalkFrom(arr.getJSONObject(i)));
    }
  }

  private static Crosswalk crosswalkFrom(JSONObject jo) throws JSONException {
    Crosswalk cw = new Crosswalk();
    cw.setFactualId(jo.getString("factual_id"));
    cw.setNamespace(jo.getString("namespace"));
    cw.setNamespaceId(jo.getString("namespace_id"));
    cw.setUrl(jo.getString("url"));
    return cw;
  }

}