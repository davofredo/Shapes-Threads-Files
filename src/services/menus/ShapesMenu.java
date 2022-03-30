package services.menus;

import services.calculates.AskingForValuesService;
import abstracts.Menu;
import constants.MenuMessages;
import enums.TypesShapesEnum;
import services.files.GenerateFileService;
import services.files.create.CreateDirService;
import services.files.create.CreateFileService;
import services.files.write.WriteFileService;
import utils.ReadInputUtil;
import java.util.Objects;
import java.util.stream.Stream;

import static constants.ShapeMessages.*;

public class ShapesMenu extends Menu {
    @Override
    public void run() {
        TypesShapesEnum typesShapesEnum;
        StringBuilder sbMenu = fillMenuText();
        AskingForValuesService asking = new AskingForValuesService();
        GenerateFileService generateFileService = new GenerateFileService();
        String shapeData = "";
        do {
            int option = ReadInputUtil.readInteger(String.valueOf(sbMenu));
            typesShapesEnum = getOptionSelected(option);
            switch (typesShapesEnum) {
                case CIRCLE:
                    shapeData = asking.askingValues(typesShapesEnum, ASKING_RATIO, UNIT);
                    generateFileService.generate(shapeData);
                    break;
                case SQUARE:
                    shapeData = asking.askingValues(typesShapesEnum, ASKING_SIDE, UNIT);
                    generateFileService.generate(shapeData);
                    break;
                case RECTANGLE:
                    shapeData = asking.askingValues(typesShapesEnum, ASKING_HEIGHT, ASKING_WIDTH, UNIT);
                    generateFileService.generate(shapeData);
                    break;
                case EQUILATERAL_TRIANGLE :
                    shapeData = asking.askingValues(typesShapesEnum, ASKING_SIDE_A, UNIT);
                    generateFileService.generate(shapeData);
                    break;
                case ISOSCELES_TRIANGLE :
                    shapeData = asking.askingValues(typesShapesEnum, ASKING_SIDE_A, ASKING_SIDE_B, UNIT);
                    generateFileService.generate(shapeData);
                    break;
            }
        }while (!Objects.equals(typesShapesEnum, MenuMessages.BACK));
    }

    @Override
    public StringBuilder fillMenuText() {
        StringBuilder textMenu = new StringBuilder(MenuMessages.SELECT_SHAPE);
        for(TypesShapesEnum t : TypesShapesEnum.values()) {
            textMenu.append(String.format(MenuMessages.SELECT_OPTION, t.getOption(), t.getOptionName()));
        }
        return textMenu;
    }

    public static TypesShapesEnum getOptionSelected(int option) {
        return Stream.of(TypesShapesEnum.values())
            .filter(o -> o.getOption() == option).findFirst().orElse(null);
    }
}