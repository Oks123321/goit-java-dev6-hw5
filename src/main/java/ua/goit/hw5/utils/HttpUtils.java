package ua.goit.hw5.utils;


import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import java.io.*;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;

public class HttpUtils {
    private static final HttpClient HTTP_CLIENT = HttpClient.newHttpClient();
    private final String URLHOST;

    public HttpUtils(String url) {
        URLHOST = url;
    }

    public HttpResponse<String> get(String url) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URLHOST + url))
                .GET()
                .build();
        HttpResponse<String> response;
        try {
            response = HTTP_CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        return response;
    }

    public HttpResponse<String> post(String url, String body) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URLHOST + url))
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .header("Content-type", "application/json")
                .build();
        HttpResponse<String> response;
        try {
            response = HTTP_CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        return response;
    }

    public HttpResponse<String> postForm(String url, String body) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URLHOST + url))
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .header("Content-type", "application/x-www-form-urlencoded")
                .build();
        HttpResponse<String> response;
        try {
            response = HTTP_CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        return response;
    }


//    public int postFileJavaUrlConnection(String url, Path path) throws IOException {
//        String charset = "UTF-8";
//        File binaryFile = new File(path.toUri());
//        String boundary = Long.toHexString(System.currentTimeMillis()); // Just generate some unique random value.
//        String CRLF = "\r\n"; // Line separator required by multipart/form-data.
//
//        HttpURLConnection connection = (HttpURLConnection) new URL(URLHOST + url).openConnection();
//        connection.setDoOutput(true);
//        connection.setUseCaches(false);
//        connection.setRequestProperty("Accept-Charset", "utf-8");
//        connection.setRequestProperty("Connection", "keep-alive");
//        connection.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + boundary);
//        connection.setRequestProperty("Accept", "application/json");
//        connection.connect();
//
//        try (
//                OutputStream output = connection.getOutputStream();
//                PrintWriter writer = new PrintWriter(new OutputStreamWriter(output, charset), true)
//        ) {
//
//            writer.append("--").append(boundary).append(CRLF);
//            writer.append("Content-Disposition: form-data;name=\"file\";" + "filename=\"" + path.getFileName() + "\"").append(CRLF).append(CRLF).flush();
//
//            Files.copy(binaryFile.toPath(), output);
//            output.flush();
//            writer.append(CRLF).append(CRLF).flush();
//            writer.append("--").append(boundary).append("--").append(CRLF).flush();
//
//            int responseCode = connection.getResponseCode();
//            System.out.println(responseCode); // Should be 200
//            return responseCode;
//        }
//
//
//    }

    public int postFileApacheHTTPClient(String url, Path filename) throws IOException {
        try (CloseableHttpClient httpclient = HttpClientBuilder.create().build()) {
            HttpPost httppost = new HttpPost(URLHOST + url);


            HttpEntity reqEntity = MultipartEntityBuilder.create()
                    .addBinaryBody("file", new File(filename.toUri()), ContentType.parse(Files.probeContentType(filename)), filename.getFileName().toString())
                    .build();


            httppost.setEntity(reqEntity);

            try (CloseableHttpResponse response = httpclient.execute(httppost)) {
                return response.getStatusLine().getStatusCode();


            }
        }
    }
    public HttpResponse<String> put(String url, String body) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URLHOST + url))
                .PUT(HttpRequest.BodyPublishers.ofString(body))
                .header("Content-type", "application/json")
                .build();
        HttpResponse<String> response;
        try {
            response = HTTP_CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        return response;
    }

    public HttpResponse<String> delete(String url) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URLHOST + url))
                .DELETE()
                .build();
        HttpResponse<String> response;
        try {
            response = HTTP_CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        return response;
    }
}
