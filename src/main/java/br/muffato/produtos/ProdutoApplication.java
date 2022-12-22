package br.muffato.produtos;

import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.server.PWA;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@PWA(name = "generated", shortName = "generated", offlineResources = {})
@NpmPackage(value = "line-awesome", version = "1.3.0")
@NpmPackage(value = "@vaadin-component-factory/vcf-nav", version = "1.0.6")
@EnableScheduling
public class ProdutoApplication implements AppShellConfigurator {

	public static void main(String[] args) {
		SpringApplication.run(ProdutoApplication.class, args);
	}
}
