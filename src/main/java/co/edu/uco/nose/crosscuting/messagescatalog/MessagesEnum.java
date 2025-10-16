package co.edu.uco.nose.crosscuting.messagescatalog;

import co.edu.uco.nose.crosscuting.helper.TextHelper;

public enum MessagesEnum {
    USER_ERROR_SQL_CONNECTION_IS_EMPTY("Conexion contra la fuente de informacion deseada vacia",
            "La conexion requerida para llevar a cabo la operacion contra la fuente de informacion deseada está vacia. "
                    + "Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicacion"),

    TECHNICAL_ERROR_SQL_CONNECTION_IS_EMPTY("Conexion contra la fuente de informacion deseada nula",
            "La conexion requerida para llevar a cabo la operacion contra la base de datos llegó nula."
                    + "Por favor intenta de nuevo y si el problema persiste, contacte al administrador de la aplicación"),

    USER_ERROR_SQL_CONNECTION_IS_CLOSED("Conexion contra la fuente de informacion deseada cerrada",
            "La conexion requerida para llevar a cabo la operacion contra la fuente de informacion deseada está cerrada. "
                    + "Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicacion"),

    TECHNICAL_ERROR_SQL_CONNECTION_IS_CLOSED("Conexion contra la fuente de informacion deseada cerrada",
            "La conexion requerida para llevar a cabo la operacion contra la base de datos llegó cerrada."
                    + "Por favor intenta de nuevo y si el problema persiste, contacte al administrador de la aplicación"),

    USER_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_CONNECTION_STATUS("Problema inesperado contra la fuente de informacion deseada vacia",
            "La conexion requerida para llevar a cabo la operacion contra la fuente de informacion deseada está vacia. "
                    + "Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicacion"),

    TECHNICAL_ERROR_SQL_CONNECTION_SQL_EXCEPTION_VALIDATING_CONNECTION_STATUS("Problema inesperado contra la fuente de informacion deseada vacia" ,
            "La conexion requerida para llevar a cabo la operacion contra la fuente de informacion deseada está vacia."
                    + "Por favor intenta de nuevo y si el problema persiste, contacte al administrador de la aplicación"),

    TECHNICAL_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_CONNECTION_STATUS("Error técnico inesperado al validar el estado de la conexión",
            "Se presentó un error técnico inesperado al intentar validar el estado de la conexión contra la base de datos. "
                    + "Por favor intente nuevamente y si el problema persiste, contacte al administrador de la aplicación"),

    USER_ERROR_TRANSACTION_IS_STARTED("Transacción no iniciada",
            "La operación no puede completarse porque la transacción requerida no ha sido iniciada. "
                    + "Por favor inicie la transacción e intente nuevamente. Si el problema persiste, contacte al administrador de la aplicación."),

    TECHNICAL_ERROR_TRANSACTION_IS_STARTED("Transacción no iniciada en la base de datos",
            "La operación no puede completarse porque la transacción requerida no fue iniciada correctamente en la base de datos. "
                    + "Por favor revise la lógica de inicio de transacciones y si el problema persiste, contacte al administrador de la aplicación."),

    USER_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_TRANSACTION_IS_STARTED("Error inesperado al validar el inicio de la transacción",
            "Se presentó un problema inesperado al validar el estado de la transacción. "
                    + "Por favor intente nuevamente y si el problema persiste, contacte al administrador de la aplicación."),

    TECHNICAL_ERROR_SQL_CONNECTION_SQL_EXCEPTION_VALIDATING_TRANSACTION_IS_STARTED("Error SQL al validar el inicio de la transacción",
            "Se produjo una excepción SQL al intentar validar el estado de la transacción. "
                    + "Por favor revise la conexión con la base de datos y si el problema persiste, contacte al administrador de la aplicación."),

    TECHNICAL_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_TRANSACTION_IS_STARTED("Error técnico inesperado al validar el inicio de la transacción",
            "Se presentó un error técnico inesperado al intentar validar el estado de la transacción. "
                    + "Por favor revise los registros del sistema y si el problema persiste, contacte al administrador de la aplicación."),

    TECHNICAL_ERROR_SQL_CONNECTION_SQL_EXCEPTION_VALIDATING_TRANSACTION_IS_NOT_STARTED(
            "Error SQL al validar que la transacción no ha sido iniciada",
            "Se produjo una excepción SQL al intentar validar que la transacción no fue iniciada. "
                    + "Por favor revise la conexión con la base de datos y si el problema persiste, contacte al administrador de la aplicación."
    ),

    USER_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_TRANSACTION_IS_NOT_STARTED(
            "Error inesperado al validar que la transacción no ha sido iniciada",
            "Se presentó un problema inesperado al validar que la transacción no ha sido iniciada. "
                    + "Por favor intente nuevamente y si el problema persiste, contacte al administrador de la aplicación."
    ),

    USER_ERROR_FIND_BY_ID_SQL("No fue posible consultar la información solicitada",
            "Se presentó un problema con la base de datos al intentar obtener la información. "
                    + "Por favor intente nuevamente más tarde."),

    TECHNICAL_ERROR_FIND_BY_ID_SQL("Error técnico SQL al consultar por ID",
            "Ocurrió una SQLException al intentar realizar la consulta por ID en la base de datos. "
                    + "Verifique la conexión, el script SQL o los parámetros enviados."),

    USER_ERROR_FIND_BY_ID_UNEXPECTED("No fue posible completar la operación",
            "Ocurrió un error inesperado al intentar obtener la información solicitada. "
                    + "Por favor intente nuevamente y si el problema persiste, contacte al administrador."),

    TECHNICAL_ERROR_FIND_BY_ID_UNEXPECTED("Error técnico inesperado al consultar por ID",
            "Se presentó una excepción inesperada al intentar consultar la información por ID en la base de datos. "
                    + "Revise los registros del sistema y contacte al administrador."),

    USER_ERROR_FIND_BY_ID_CRITICAL("Error crítico al consultar la información solicitada",
            "Ocurrió un fallo crítico en el sistema al intentar realizar la consulta. "
                    + "Por favor contacte al administrador del sistema de inmediato."),

    TECHNICAL_ERROR_FIND_BY_ID_CRITICAL("Error técnico crítico al consultar por ID",
            "Se presentó un error grave al intentar ejecutar la operación de consulta por ID. "
                    + "Verifique la infraestructura de base de datos o el entorno de ejecución."),
    ;


    private String title;
    private String content;

    private MessagesEnum(final String title, final String content) {
        this.title = title;
        this.content = content;
    }

    public static String TECHNICAL_ERROR_FIND_BY_ID_CRITICAL() {
        return null;
    }

    public String getTitle() {
        return title;
    }

    private void setTitle(final String title) {
        this.title = TextHelper.getDefaultWithTrim(title);
    }

    public String getContent() {
        return content;
    }

    private void setContent(final String content) {
        this.content = TextHelper.getDefaultWithTrim(content);
    }
}
