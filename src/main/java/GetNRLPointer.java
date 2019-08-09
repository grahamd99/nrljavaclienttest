import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class GetNRLPointer {
    public static void main(String[] args) throws Exception {
        String payload = "";
        StringEntity entity = new StringEntity(payload,
                ContentType.APPLICATION_FORM_URLENCODED);

        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet("https://data.developer.nhs.uk/nrls-ri/DocumentReference?subject=https%3A%2F%2Fdemographics.spineservices.nhs.uk%2FSTU3%2FPatient%2F9434765919&type.coding=http%3A%2F%2Fsnomed.info%2Fsct%7C736253002");
        //request.setEntity(entity);
        request.addHeader("ContentType", "application/json");
        request.addHeader("Accept", "application/json");
        request.addHeader("fromASID", "200000000117");
        request.addHeader("toASID", "999999999999");
        request.addHeader( "Authorization", "Bearer eyJhbGciOiJub25lIiwidHlwIjoiSldUIn0.eyJpc3MiOiJodHRwczovL2RlbW9uc3RyYXRvci5jb20iLCJzdWIiOiJodHRwczovL2ZoaXIubmhzLnVrL0lkL3Nkcy1yb2xlLXByb2ZpbGUtaWR8ZmFrZVJvbGVJZCIsImF1ZCI6Imh0dHBzOi8vbnJscy5jb20vZmhpci9kb2N1bWVudHJlZmVyZW5jZSIsImV4cCI6MTU2MzE4OTc5NSwiaWF0IjoxNTYzMTg5NDk1LCJyZWFzb25fZm9yX3JlcXVlc3QiOiJkaXJlY3RjYXJlIiwic2NvcGUiOiJwYXRpZW50L0RvY3VtZW50UmVmZXJlbmNlLnJlYWQiLCJyZXF1ZXN0aW5nX3N5c3RlbSI6Imh0dHBzOi8vZmhpci5uaHMudWsvSWQvYWNjcmVkaXRlZC1zeXN0ZW18MjAwMDAwMDAwMTE3IiwicmVxdWVzdGluZ19vcmdhbml6YXRpb24iOiJodHRwczovL2ZoaXIubmhzLnVrL0lkL29kcy1vcmdhbml6YXRpb24tY29kZXxBTVMwMSIsInJlcXVlc3RpbmdfdXNlciI6Imh0dHBzOi8vZmhpci5uaHMudWsvSWQvc2RzLXJvbGUtcHJvZmlsZS1pZHxmYWtlUm9sZUlkIn0=.");

        HttpResponse response = httpClient.execute(request);
        int HttpResult = response.getStatusLine().getStatusCode();
        System.out.println( "HTTP Response code " + HttpResult + "\n" + response.toString());

        //display what is returned by the GET request
        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

        try {
            String line = "";
             while ((line = rd.readLine()) != null) {
                 System.out.println(line);
                 if (line.startsWith("Auth=")) {
                     String key = line.substring(5);
                     // Do something with the key
                 }
             }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
