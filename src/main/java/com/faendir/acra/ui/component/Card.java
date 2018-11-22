package com.faendir.acra.ui.component;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.HasStyle;
import com.vaadin.flow.component.html.Div;

/**
 * @author lukas
 * @since 18.10.18
 */
public class Card extends Composite<Div> implements HasSize, HasStyle {
    private final Div header;
    private final Div content;
    private boolean allowCollapse = false;

    public Card() {
        getContent().getStyle().set("box-shadow", "0 3px 6px rgba(0,0,0,0.16), 0 3px 6px rgba(0,0,0,0.23)");
        getContent().getStyle().set("border-radius", "2px");
        getContent().getStyle().set("margin", "1rem");
        getContent().getStyle().set("display", "inline-block");
        header = new Div();
        header.getStyle().set("padding", "1rem");
        header.getStyle().set("box-sizing", "border-box");
        header.getStyle().set("background-color", "var(--lumo-contrast-5pct)");
        header.getStyle().set("display", "inline-block");
        header.setWidth("100%");
        header.addClickListener(e -> {
            if (allowCollapse) {
                if (isCollapsed()) {
                    expand();
                } else {
                    collapse();
                }
            }
        });
        content = new Div();
        content.getStyle().set("padding", "1rem");
        content.getStyle().set("box-sizing", "border-box");
        content.getStyle().set("display", "inline-block");
        content.setSizeFull();
        getContent().add(header, content);
    }

    public Card(Component... components) {
        this();
        add(components);
    }

    public void removeAll() {
        content.removeAll();
    }

    public void addComponentAtIndex(int index, Component component) {
        content.addComponentAtIndex(index, component);
    }

    public void addComponentAsFirst(Component component) {
        content.addComponentAsFirst(component);
    }

    public void add(Component... components) {
        content.add(components);
    }

    public void remove(Component... components) {
        content.remove(components);
    }

    public void setHeader(Component... components) {
        header.removeAll();
        header.add(components);
    }

    public boolean allowsCollapse() {
        return allowCollapse;
    }

    public void setAllowCollapse(boolean allowCollapse) {
        this.allowCollapse = allowCollapse;
    }

    public void collapse() {
        content.getStyle().set("display", "none");
    }

    public void expand() {
        content.getStyle().set("display", "inline-block");
    }

    public boolean isCollapsed() {
        return content.getStyle().get("display").equals("none");
    }
}