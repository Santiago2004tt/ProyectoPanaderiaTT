package com.proyect.proyectopanaderiatt.util;

public class BodyEmailUtil {

    public static String textMail(String destinatario, String remitente) {
        return String.format("""
                <html lang="es">
                <head>
                    <meta charset="UTF-8">
                    <title>Asunto del Correo Electrónico</title>
                    <style>
                        /* Estilos generales */
                        body {
                            font-family: Arial, sans-serif;
                            margin: 0;
                            padding: 0;
                            background-color: #f4f4f4;
                        }

                        /* Estilos para el encabezado */
                        .header {
                            background-color: #0073e6;
                            color: white;
                            padding: 20px;
                            text-align: center;
                        }

                        /* Estilos para el contenido */
                        .content {
                            padding: 20px;
                            background-color: #ffffff;
                            text-align: center;
                        }

                        /* Estilos para los enlaces */
                        a {
                            color: #0073e6;
                            text-decoration: none;
                        }

                        /* Estilos para el pie de página */
                        .footer {
                            background-color: #f4f4f4;
                            padding: 20px;
                            text-align: center;
                        }
                    </style>
                </head>
                <body>
                    <table width="100%%" cellspacing="0" cellpadding="0">
                        <tr>
                            <td class="header">
                                <h1>¡Su registro se realizó correctamente!</h1>
                            </td>
                        </tr>
                        <tr>
                            <td class="content">
                                <table width="100%%" cellspacing="0" cellpadding="0">
                                    <tr>
                                        <td style="text-align: center;">
                                            <p style="font-size: 18px; color: #333;">Estimado/a %s,</p>
                                            <p style="font-size: 18px; color: #333;> Bienvenido a nuestra pastelería ahora puede realizar pedidos</p>
                                            <p style="font-size: 16px; color: #555;">¡Esperamos tengas una buena experiencia!</p>
                                            <p style="font-size: 16px; color: #555;">Atentamente,</p>
                                            <p style="font-size: 18px; color: #333;">%s</p>
                                        </td>
                                    </tr>
                                </table>
                            </td>
                        </tr>
                    </table>
                </body>
                </html>"""
                , destinatario
                , remitente);
    }
}
