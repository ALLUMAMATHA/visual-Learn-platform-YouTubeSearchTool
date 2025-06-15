package com.Project;
/**
 * 📌 Project Title : Visual Learn Platform - Smart Topic Search (Google + YouTube)
 * 👤 Author        : Allu Mamatha (Concept Creator)
 * 💬 Description   :
 * This Java app opens a topic search:
 *   ✅ In Google Chrome → Google search focused on YouTube content
 *   ✅ In default browser → YouTube search showing standard layout (Shorts, Videos, Filters)
 *
 * 📌 Note: YouTube does not allow visible duration sections (like “4–20 min”) as tabs.
 *         Users must click the “Filters” button to choose duration filters manually.
 */

import java.awt.Desktop;                      // To open system default browser
import java.io.IOException;                  // To handle input/output exceptions
import java.net.URI;                         // To create web link for default browser
import java.net.URLEncoder;                  // To encode search query into URL format
import java.nio.charset.StandardCharsets;    // To specify UTF-8 encoding
import java.util.Scanner;                    // To read input from the user

public class YouTubeSearchTool {

    public static void main(String[] args) {

        // 🎉 Display a welcome message to the user
        System.out.println("\n✨ Welcome to the Visual Learn Platform! ✨\n");
        System.out.println("-----------------------------------------------");

        // 📘 Prompt user to enter a topic they want to search for
        Scanner scanner = new Scanner(System.in);               // Create scanner to read user input
        System.out.print("📘 Enter a topic you want to learn about: ");
        String topic = scanner.nextLine().trim();               // Read and trim the topic input
        scanner.close();                                        // Close the scanner to free resources

        // 🌐 Encode the topic for safe use in a URL (spaces, special characters)
        String encodedTopic = URLEncoder.encode(topic, StandardCharsets.UTF_8);

        // 🔗 Construct the final URLs:
        // Google search limited to YouTube site
        String googleSearchURL = "https://www.google.com/search?q=" + encodedTopic + "+site:youtube.com";
        // YouTube search directly
        String youtubeSearchURL = "https://www.youtube.com/results?search_query=" + encodedTopic;

        try {
            // 🧭 Step 1: Open Google search URL in Chrome (new window)
            String chromeCommand = "cmd /c start chrome --new-window \"" + googleSearchURL + "\"";
            Runtime.getRuntime().exec(chromeCommand);           // Execute the Chrome command
            System.out.println("🌐 Google search opened in Chrome.");

            // 🎥 Step 2: Open YouTube search in system's default browser
            if (Desktop.isDesktopSupported()) {                 // Check if Desktop API is supported
                Desktop.getDesktop().browse(new URI(youtubeSearchURL));  // Open URL in default browser
                System.out.println("🎥 YouTube search opened in your default browser.");
            }

        } catch (IOException e) {
            // 🛑 Handle any input/output related issues
            System.err.println("❌ IO Error: " + e.getMessage());

        } catch (Exception e) {
            // 🛑 Handle general errors (like URI issues)
            System.err.println("❌ General Error: " + e.getMessage());
        }

        // 💡 Final guidance for users to filter by video duration on YouTube manually
        System.out.println("\n📌 Tip: On the YouTube search page, click the 'Filters' button.");
        System.out.println("   Then choose a video duration:");
        System.out.println("   - < 4 minutes");
        System.out.println("   - 4–20 minutes");
        System.out.println("   - 20+ minutes");
        System.out.println("   - Any duration");

        // 🎯 Goodbye message
        System.out.println("\n🎯 Happy Visual Learning! 🌟");
    }
}
