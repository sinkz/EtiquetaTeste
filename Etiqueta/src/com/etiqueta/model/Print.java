package com.etiqueta.model;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;



public class Print {

	public static void main(String[] args) {
		List<Contrato>listaContrato = new ArrayList<>();
		Contrato c = new Contrato();
		c.setContrato("1234");
		c.setContratante("Diego Augusto Gonçalves");
		c.setCidade("Jacarezinho");
		c.setUf("PR");
		c.setRua("Paul Percy Harris");
		c.setNumero("444");
		c.setCep("86400-000");
		c.setBairro("Centro");
		listaContrato.add(c);
		
		c = new Contrato();
		c.setContrato("4444444");
		c.setContratante("Rodrigo");
		c.setCidade("Sao Paulo");
		c.setUf("SP");
		c.setRua("Rua Teste");
		c.setNumero("444");
		c.setCep("832-323");
		c.setBairro("Centro");
		listaContrato.add(c);
		
		
		c = new Contrato();
		c.setContrato("323");
		c.setContratante("Joaquim Aparecido da Silva");
		c.setCidade("Sao Paulo");
		c.setUf("SP");
		c.setRua("Rua Teste");
		c.setNumero("444");
		c.setCep("832-323");
		c.setBairro("Centro");
		listaContrato.add(c);
		
		c = new Contrato();
		c.setContrato("42113");
		c.setContratante("Fabio");
		c.setCidade("Sao Paulo");
		c.setUf("SP");
		c.setRua("Rua Teste");
		c.setNumero("444");
		c.setCep("832-323");
		c.setBairro("Centro");
		listaContrato.add(c);
		
		gerarTxt(listaContrato);
	
		
	}

	public static void gerarTxt(List<Contrato> lista) {

		try {
			FileWriter arq = new FileWriter("C:\\etiquetaTeste.txt");
			PrintWriter gravarArq = new PrintWriter(arq);

			for (int i = 0; i < lista.size(); i += 2) {
				Contrato c1 = lista.get(i);
				Contrato c2 = lista.get(i + 1);
				
				int tamanhoString1 = c1.getCep().length() + c1.getCidade().length() + 1;
				int tamanhoString2 = c2.getCep().length() + c2.getCidade().length() + 1;
				
				gravarArq.print(StringUtils.leftPad(c1.getContrato(), 0) + " " + StringUtils.leftPad(c2.getContrato(), 41));
				gravarArq.print("\r\n");
				
				gravarArq.print(StringUtils.leftPad(c2.getContratante(),  0) + " " + StringUtils.leftPad(c2.getContratante(),  41));
				gravarArq.print("\r\n");
				
				gravarArq.print(StringUtils.leftPad(c1.getRua() + ", " + c1.getNumero(), 0) + " "
						+ StringUtils.leftPad(c2.getRua().trim() + ", " + c2.getNumero().trim(), 41));
				gravarArq.print("\r\n");
				
				gravarArq.print(StringUtils.leftPad(c1.getBairro().trim(), 0) + " " + StringUtils.leftPad(c2.getBairro().trim(), 41));
				gravarArq.print("\r\n");

				gravarArq.print(StringUtils.leftPad(c1.getCep().trim() + " " + c1.getCidade().trim(), 0) + " "
						+ StringUtils.leftPad(c1.getUf().trim(), 39 - tamanhoString1) + " "
						+ StringUtils.leftPad(c2.getCep().trim() + " " + c2.getCidade().trim(), 29) + " "
						+ StringUtils.leftPad(c2.getUf().trim(), 39-tamanhoString2));
				gravarArq.print("\r\n");
				gravarArq.print(".");
				gravarArq.print("\r\n");
			}

			arq.close();
			System.out.println("Arquivo gerado em C: ");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
