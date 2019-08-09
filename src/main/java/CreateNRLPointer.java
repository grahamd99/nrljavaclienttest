import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

public class CreateNRLPointer {
    public static void main(String[] args) throws Exception {
        String payload = "data={" + "}";

        /*
        String payload = "data={" +
 \"resourceType\": \"DocumentReference\",  \"meta\": {    \"profile\": [      \"https://fhir.nhs.uk/STU3/StructureDefinition/NRL-DocumentReference-1\"    ]  },  \"status\": \"current\",  \"type\": {    \"coding\": [      {        \"system\": \"http://snomed.info/sct\",        \"code\": \"736253002\",        \"display\": \"Mental health crisis plan\"      }    ]  },  \"class\": {    \"coding\": [      {        \"system\": \"http://snomed.info/sct\",        \"code\": \"734163000\",        \"display\": \"Care plan\"      }    ]  },  \"subject\": {    \"reference\": \"https://demographics.spineservices.nhs.uk/STU3/Patient/9434765919\"  },  \"indexed\": \"2016-03-08T15:26:01+01:00\",  \"author\": [    {      \"reference\": \"https://directory.spineservices.nhs.uk/STU3/Organization/1XR\"    }  ],  \"custodian\": {    \"reference\": \"https://directory.spineservices.nhs.uk/STU3/Organization/MHT01\"  },  \"content\": [    {      \"attachment\": {        \"contentType\": \"application/pdf\",        \"url\": \"https://spine-proxy.national.ncrs.nhs.uk/p1.nhs.uk/MentalhealthCrisisPlanReport_123.pdf\",        \"title\": \"Mental health Crisis Plan Report\",        \"creation\": \"2016-03-08T15:26:00+01:00\"      },      \"format\": {        \"system\": \"https://fhir.nhs.uk/STU3/CodeSystem/NRL-FormatCode-1\",        \"code\": \"proxy:https://www.iso.org/standard/63534.html\",        \"display\": \"PDF\"      },      \"extension\": [        {          \"url\": \"https://fhir.nhs.uk/STU3/StructureDefinition/Extension-NRL-ContentStability-1\",          \"valueCodeableConcept\": {            \"coding\": [              {                \"system\": \"https://fhir.nhs.uk/STU3/CodeSystem/NRL-ContentStability-1\",                \"code\": \"static\",                \"display\": \"Static\"              }            ]          }        }      ]    }  ],  \"context\": {    \"period\": {      \"start\": \"2016-03-07T13:34:00+01:00\"    },    \"practiceSetting\": {      \"coding\": [        {          \"system\": \"http://snomed.info/sct\",          \"code\": \"892811000000109\",          \"display\": \"Adult mental health service\"        }      ]    }  }}"
*/
        StringEntity entity = new StringEntity(payload,
                ContentType.APPLICATION_FORM_URLENCODED);

        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost request = new HttpPost("https://data.developer.nhs.uk/nrls-ri/DocumentReference?subject=https%3A%2F%2Fdemographics.spineservices.nhs.uk%2FSTU3%2FPatient%2F9434765919&type.coding=http%3A%2F%2Fsnomed.info%2Fsct%7C736253002");
        //request.setEntity(entity);
        request.addHeader("ContentType", "application/json");
        request.addHeader("Accept", "application/json");
        request.addHeader("fromASID", "200000000117");
        request.addHeader("toASID", "999999999999");
        request.addHeader( "Authorization", "Bearer eyJhbGciOiJub25lIiwidHlwIjoiSldUIn0.eyJpc3MiOiJodHRwczovL2RlbW9uc3RyYXRvci5jb20iLCJzdWIiOiJodHRwczovL2ZoaXIubmhzLnVrL0lkL3Nkcy1yb2xlLXByb2ZpbGUtaWR8ZmFrZVJvbGVJZCIsImF1ZCI6Imh0dHBzOi8vbnJscy5jb20vZmhpci9kb2N1bWVudHJlZmVyZW5jZSIsImV4cCI6MTU2MzE4OTc5NSwiaWF0IjoxNTYzMTg5NDk1LCJyZWFzb25fZm9yX3JlcXVlc3QiOiJkaXJlY3RjYXJlIiwic2NvcGUiOiJwYXRpZW50L0RvY3VtZW50UmVmZXJlbmNlLnJlYWQiLCJyZXF1ZXN0aW5nX3N5c3RlbSI6Imh0dHBzOi8vZmhpci5uaHMudWsvSWQvYWNjcmVkaXRlZC1zeXN0ZW18MjAwMDAwMDAwMTE3IiwicmVxdWVzdGluZ19vcmdhbml6YXRpb24iOiJodHRwczovL2ZoaXIubmhzLnVrL0lkL29kcy1vcmdhbml6YXRpb24tY29kZXxBTVMwMSIsInJlcXVlc3RpbmdfdXNlciI6Imh0dHBzOi8vZmhpci5uaHMudWsvSWQvc2RzLXJvbGUtcHJvZmlsZS1pZHxmYWtlUm9sZUlkIn0=.");

        HttpResponse response = httpClient.execute(request);
        System.out.println(response.getStatusLine().getStatusCode());
    }
}
