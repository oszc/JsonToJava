package com.jsontojava;

public class Main {
	private static final String OPTION_PACKAGE = "package";
	private static final String OPTION_URL = "url";
	private static final String OPTION_ROOT = "class";
	private static final String OPTION_GSON = "g";
	private static final String OPTION_PARCELABLE = "p";


//	/**
//	 * @param args
//	 * @throws IOException
//	 */
//	public static void main(String[] args) throws IOException {
//		Options options = createOptions();
//		
//		CommandLineParser parser = new BasicParser();
//		CommandLine cmd = parser.parse( options, args);
//		JsonToJava jsonToJava = new JsonToJava();
//		
//		jsonToJava.setUrl(cmd.getOptionValue(OPTION_URL));
//		jsonToJava.setPackage(cmd.getOptionValue(OPTION_PACKAGE));
//		jsonToJava.setBaseType(cmd.getOptionValue(OPTION_ROOT));
//		
//		jsonToJava.fetchJson();
//		jsonToJava.outputZipFile();
//	
//
//	}
//
//
//
//	private static Options createOptions(){
//		Options options = new Options();
//		options.addOption(OPTION_PARCELABLE, false, "Enabled implementation of Parcelable for all classes generated");
//		options.addOption(OPTION_GSON,false,"Enables Gson annotations");
//		Option rootClass = OptionBuilder.hasArg().isRequired().withDescription("The name of the root class of the feed you are parsing").create(OPTION_ROOT);
//		options.addOption(rootClass);
//		Option url = OptionBuilder.hasArg().isRequired().withDescription("The url of the json feed you want to parse").create(OPTION_URL);
//		options.addOption(url);
//		Option pack = OptionBuilder.hasArg().isRequired().withDescription("The package name for the generated classes").create(OPTION_PACKAGE);
//		options.addOption(pack);
//		
//		return options;
//		
//		
//	}
//
//	

	
}
