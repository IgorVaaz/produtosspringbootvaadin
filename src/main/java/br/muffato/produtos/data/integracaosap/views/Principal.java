package br.muffato.produtos.data.integracaosap.views;

import br.muffato.produtos.data.integracaosap.components.AppNav;
import br.muffato.produtos.data.integracaosap.components.AppNavItem;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Header;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.theme.lumo.LumoUtility;

public class Principal extends AppLayout {

    public Principal(){
        setPrimarySection(Section.DRAWER);
        addDrawerContent();
    }

    private void addDrawerContent(){
        H1 appName = new H1("Produtos e Pedidos");
        appName.addClassNames(LumoUtility.FontSize.LARGE, LumoUtility.Margin.NONE);
        Header header = new Header(appName);

        Scroller scroller = new Scroller(createNavigation());

        addToDrawer(header, scroller);
    }

    private AppNav createNavigation(){
        AppNav nav = new AppNav();

        nav.addItem(new AppNavItem("Produtos", ProdutosView.class));
        nav.addItem(new AppNavItem("Pedidos", PediVtexView.class));

        return nav;
    }
}


















