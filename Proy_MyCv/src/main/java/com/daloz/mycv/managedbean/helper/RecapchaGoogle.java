package com.daloz.mycv.managedbean.helper;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class RecapchaGoogle
{
	public static Boolean validateRecaptcha(String response)
	{
		try
		{

			URL url = new URL("https://www.google.com/recaptcha/api/siteverify");

			HttpURLConnection connection = (HttpURLConnection) url.openConnection();

			// Propiedades
			connection.setRequestMethod("POST");


			String keySecret = "6LfvORoTAAAAAMUz4noAbqG-L-V7nnWDD-kIwwDJ";

			String postParameter = "secret=" + keySecret + "&response=" + response;


			// Send post request
			connection.setDoOutput(true);

			DataOutputStream dataOutputStream = new DataOutputStream(connection.getOutputStream());
			dataOutputStream.writeBytes(postParameter);
			dataOutputStream.flush();
			dataOutputStream.close();


			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

			String inputLine;
			
			StringBuffer respuesta = new StringBuffer();

			while ((inputLine = bufferedReader.readLine()) != null)
			{
				respuesta.append(inputLine);
			}
			bufferedReader.close();

			JsonObject jsonObject = new JsonParser().parse(respuesta.toString()).getAsJsonObject();


			return jsonObject.get("success").getAsBoolean();
		}
		catch (IOException e)
		{
			e.printStackTrace();
			return false;
		}
	}
}
