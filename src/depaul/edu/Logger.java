package depaul.edu;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

class Logger {
    private static final String LOG_FILE = "Log.txt";
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    // Logs message with timestamp.
    public static void log(String message) {
        String timestampedMessage = getTimestamp() + " " + message;
        writeLog(timestampedMessage);
    }

    //It will write the log message to a log file.
    private static void writeLog(String logMessage) {
        try (FileWriter writer = new FileWriter(LOG_FILE, true)) {
            writer.write(logMessage + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getTimestamp() {
        return dateFormat.format(new Date());
    }
}


