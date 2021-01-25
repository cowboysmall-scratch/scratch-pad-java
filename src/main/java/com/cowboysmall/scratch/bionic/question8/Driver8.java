package com.cowboysmall.scratch.bionic.question8;

import java.util.Collection;

public class Driver8 {


    public static void main(String[] args) throws Exception {
        String xml =
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                        "<folder name=\"c\">" +
                        "<folder name=\"program files\">" +
                        "<folder name=\"uninstall information\" />" +
                        "</folder>" +
                        "<folder name=\"users\" />" +
                        "</folder>";

        Collection<String> names = Folders.folderNames(xml, 'u');
        for (String name : names)
            System.out.println(name);
    }
}
