package mvc;

public class Controller {
	
	public void temp() {
//		// Provide an UI to start, pause, stop the service
//				/*
//				 * |--------------------------------|
//				 * | Path to monitor       Choose	| 
//				 * | Start	Pause	Stop			|
//				 * | State of the service(color)	| //TODO: state bar
//				 * |--------------------------------|
//				 */
//				stage.setTitle(APPLICATION_TITLE);
//				stage.setHeight(APPLICATION_HEIGHT);
//				stage.setWidth(APPLICATION_WIDTH);
//				
//				Label pathLabel = new Label(); //get it from config file, immutable to user
//				final Button dirChooseButton = new Button("Choose...");
//				final Button startButton = new Button("start");
//				final Button pauseButton = new Button("pause");
//				final Button stopButton = new Button("stop");
//				
//				dirChooseButton.setAlignment(Pos.TOP_RIGHT);
//				dirChooseButton.setOnAction(new EventHandler<ActionEvent>() {
//					@Override
//					public void handle(ActionEvent arg0) {
//						final DirectoryChooser directoryChooser = new DirectoryChooser();
//						final File selectedDir = directoryChooser.showDialog(stage);
//						if(selectedDir != null) {
//							folderToMonitor = selectedDir;
//							pathLabel.setText(folderToMonitor.getAbsolutePath());
//						}
//					}
//				});
//				
//				startButton.setOnAction(new EventHandler<ActionEvent>() {
//					@Override
//					public void handle(ActionEvent arg0) {
//						// file monitor starts when the start button is pressed
//						// TODO: register itself to the Server
//						
//						if(folderToMonitor == null)
//							return;
//						fileMonitor = new FileMonitor(folderToMonitor.toPath());
//						fileMonitor.start();
//						logger.info("File monitor started...");
//					}
//				});
//				
//				pauseButton.setOnAction(new EventHandler<ActionEvent>() {
//					@Override
//					public void handle(ActionEvent arg0) {
//						logger.info("pause not implemented...");
//					}
//				});
//				
//				stopButton.setOnAction(new EventHandler<ActionEvent>() {
//					@Override
//					public void handle(ActionEvent arg0) {
//						// file monitor stops when the stop button is pressed
//						if(fileMonitor == null)
//							return;
//						fileMonitor.stopThread();
//						logger.info("File monitor stopped...");
//					}
//				});
//				
//				final GridPane grid = new GridPane();
//				GridPane.setConstraints(pathLabel, 0, 0);
//				GridPane.setConstraints(dirChooseButton, 1, 0);
//				GridPane.setConstraints(startButton, 0, 1);
//				GridPane.setConstraints(pauseButton, 1, 1);
//				GridPane.setConstraints(stopButton, 2, 1);
//				grid.setHgap(6);
//				grid.setVgap(6);
//				grid.getChildren().addAll(pathLabel, dirChooseButton, startButton, pauseButton, stopButton);
//				
//				final Pane rootGroup = new VBox(12);
//				rootGroup.getChildren().addAll(grid);
//				rootGroup.setPadding(new Insets(20, 12, 12, 12));
//				
//				stage.setScene(new Scene(rootGroup));
//				stage.show();
	}
}
