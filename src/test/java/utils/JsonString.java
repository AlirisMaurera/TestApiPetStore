package utils;

public class JsonString {

    public String getJson(String idCategory, String nameCategory, String name, String photoUrls, String idTags, String nameTag, String status){
        String json = "{\"id\": 0,\"category\": {\"id\": "+idCategory+",\"name\": \""+nameCategory+"\"},"+
        "\"name\": \""+name+"\",\"photoUrls\": [\""+photoUrls+"\"],\"tags\": [ {\"id\": \""+idTags+"\",\"name\": \""+nameTag+
                "\"} ],\"status\": \""+status+"\"}";

        return json;
    }
}
