package Commands;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.w3c.dom.Text;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import LetJerryEat.BerryChan;
import LetJerryEat.TokenManager;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import okhttp3.*;

public class Voiceflow extends ListenerAdapter {
    
    public void onGuildMessageReceived(GuildMessageReceivedEvent event){

        String[] args = event.getMessage().getContentRaw().split("\\s+");

        // Launch VoiceFlow bot
        if (!event.getAuthor().isBot() && args[0].equals(BerryChan.prefix + "v") && args.length == 1) {
            
            OkHttpClient client = new OkHttpClient();
            
            MediaType mediaType = MediaType.parse("application/json");

            RequestBody body = RequestBody.create(mediaType, "{\"action\":{\"type\":\"launch\"},\"config\":{\"tts\":false,\"stripSSML\":true,\"stopAll\":true,\"excludeTypes\":[\"block\",\"debug\",\"flow\"]}}");


            Request request = new Request.Builder()
            .url("https://general-runtime.voiceflow.com/state/user/Discord_Bot/interact")
            .post(body)
            .addHeader("accept", "application/json")
            .addHeader("content-type", "application/json")
            .addHeader("Authorization", TokenManager.getVoiceflowAPIToken())
            .build();

            try {
                okhttp3.Response response = client.newCall(request).execute();
                
                // Parse the JSON response using Jackson
                ObjectMapper objectMapper = new ObjectMapper();
                JsonNode jsonResponse = objectMapper.readTree(response.body().string());

                // Access the "content" array and then the first object
                JsonNode contentNode = jsonResponse.get(0).get("payload").get("slate").get("content").get(0);

                // Access the "children" array
                JsonNode childrenNode = contentNode.get("children");

                // Iterate over the children array and get the "text" field
                for (JsonNode child : childrenNode) {
                    String text = child.get("text").asText();
                    event.getChannel().sendTyping().queue();
                    event.getChannel().sendMessage(text).queue();
                }

                

                
            } catch (IOException e) {
                e.printStackTrace();
            }


        } else if (!event.getAuthor().isBot() && args[0].equals(BerryChan.prefix + "v")) {
            event.getChannel().sendTyping().queue();
            String userRequest = "";

            for (int i = 1; i < args.length; i++) {
                userRequest += args[i] + " ";
            }
            System.out.println("[Message]:"+userRequest);
            
            OkHttpClient client = new OkHttpClient.Builder()
                .callTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .build();

            MediaType mediaType = MediaType.parse("application/json");
            RequestBody body = RequestBody.create(mediaType, "{\"action\":{\"type\":\"text\",\"payload\":\"" + userRequest + "\"},\"config\":{\"tts\":false,\"stripSSML\":true,\"stopAll\":true,\"excludeTypes\":[\"block\",\"debug\",\"flow\"]}}");
            Request request = new Request.Builder()
            .url("https://general-runtime.voiceflow.com/state/user/Discord_Bot/interact?verbose=false")
            .post(body)
            .addHeader("accept", "application/json")
            .addHeader("content-type", "application/json")
            .addHeader("Authorization", TokenManager.getVoiceflowAPIToken())
            .build();

            try {
                okhttp3.Response response = client.newCall(request).execute();
                
                // Parse the JSON response using Jackson
                ObjectMapper objectMapper = new ObjectMapper();
                JsonNode jsonResponse = objectMapper.readTree(response.body().string());

                System.out.println(jsonResponse.toString());;


                // Determine the type of response
                for (JsonNode node : jsonResponse) {
                    String type = node.get("type").asText();
                    if (type.equals("text")) {
                        // Extract message field for text type
                        String message = node.get("payload").get("message").asText();
                        event.getChannel().sendMessage(message).queue();
                    } else if (type.equals("visual")) {
                        // Extract image field for visual type
                        String image = node.get("payload").get("image").asText();
                        event.getChannel().sendMessage(image).queue();
                    }
                }
                

                
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



    }

}
