package hu.dss.service;

import hu.dss.util.Message;
import hu.dss.util.Separator;

import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class InputServiceImpl implements InputService {
    private final Scanner scanner;

    public InputServiceImpl() {
        this.scanner = new Scanner(new InputStreamReader(System.in, StandardCharsets.UTF_8));
    }

    @Override
    public String getValidFilePathFromUser() {
        String filePath = "";

        while (true) {
            System.out.println(Message.ENTER_FILE_PATH.getMessage());

            filePath = scanner.nextLine().trim();
            Path path = Paths.get(filePath);

            if (!Files.isRegularFile(path) || !Files.exists(path)) {
                System.err.println(Message.INVALID_FILE_PATH.getMessage());
            } else {
                break;
            }
        }

        return filePath;
    }

    @Override
    public Separator getSeparatorChoiceFromUser() {
        String separatorChoice = "";
        Separator separator;

        while (true) {
            System.out.println(Message.CHOOSE_SEPARATOR.getMessage());
            System.out.println(Message.CHOOSE_SEPARATOR_OPTION_PIPE.getMessage());
            System.out.println(Message.CHOOSE_SEPARATOR_OPTION_SEMICOLON.getMessage());
            System.out.println(Message.CHOOSE_SEPARATOR_ENTER_CHOICE.getMessage());

            separatorChoice = scanner.nextLine().trim();
            separator = Separator.getSeparatorByCode(separatorChoice);

            if (separator == null) {
                System.err.println(Message.CHOOSE_SEPARATOR_INVALID_CHOICE.getMessage());
            } else {
                break;
            }
        }

        return separator;
    }

}
