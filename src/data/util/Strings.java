package data.util;

public class Strings {

	public static final String MENU_MEMBER_PAGE = "\nSELECIONE ALGUMA OPÇÃO\n\n" + "1- Cadastrar novos sócios\n"
			+ "2- Consultar por documento\n" + "3- Consultar por nome\n"
			+ "4- Atualizar um registro por número de carteirinha\n" + "5- Excluir registro por número de carteirinha\n"
			+ "6- Voltar para página inicial\n";
	
	public static final String MENU_DOCUMENT_ALREDY_EXISTS = "\n1- inserir um novo documento\n2- voltar para as opções";
	
	public static final String WRITE_MEMBER_NAME = "Digite o nome do Sócio: ";
	public static final String WRITE_CARD_NUMBER = "Digite o numero da carteirinha: ";
	
	public static final String WRITE_DOCUMENT_TYPE = "Digite o tipo de documento(RG/CPF): ";
	
	public static final String MEMBER_SUCCESSFULLY_INSERTED = "*Sócio adicionado com sucesso!*";
	public static final String MEMBER_SUCCESSFULLY_DELETED = "*Sócio excluído com sucesso!*";
	
	public static final String MEMBERS_FINDED = "Sócios encontrados: ";
	
	public static final String ERROR_DOCUMENT_INVALID = "*ERRO: Documento inválido*";
	public static final String ERROR_DOCUMENT_ALREDY_EXISTS = "\n*ERRO: Documento já existente*";
	public static final String ERROR_MEMBER_NOT_FOUND = "*ERRO: Sócio não encontrado*";
	public static final String ERROR_TO_INSERT_MEMBER = "*ERRO: Falha ao inserir Sócio*";
	public static final String ERROR_INVALID_VALUE = "\n*ERRO: Valor inválido*";
	public static final String ERROR_VALUE_MUST_BE_A_NUMBER = "*ERRO: O valor deve ser um numero*";
	public static final String ERROR_INVALID_NAME = "*ERRO: Nome só pode conter caracteres de A-Z*";
	
	public static String updatedMember(String name) {
		return "Sócio:" + name + " atualizado com sucesso!";
	}
	
	public static String writeDocumentValue(String documentType) {
		return "Digite o numero do " + documentType + "(somente números): ";
	}

}
