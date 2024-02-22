package se.ju23.typespeeder.gameLogic;

public interface IChallenge {
    String printListOfGames();

    String printListOfEasyGames();

    String chooseGame(int id);

    void calculateTimeToDouble();

    int getRandomWordsAccordingToLevel();

    void startChallenge();

    void endChallenge();
    void setCurrentGameTaskId();

    void getAndSetCurrentLanguage();

    int getGameListSize();
}
