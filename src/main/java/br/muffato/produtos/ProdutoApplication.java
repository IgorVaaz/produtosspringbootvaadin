package br.muffato.produtos;

import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.server.PWA;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
//@Theme(value = "generated")
@PWA(name = "generated", shortName = "generated", offlineResources = {})
@NpmPackage(value = "line-awesome", version = "1.3.0")
public class ProdutoApplication implements AppShellConfigurator {

	public static void main(String[] args) {
		SpringApplication.run(ProdutoApplication.class, args);
	}
}
