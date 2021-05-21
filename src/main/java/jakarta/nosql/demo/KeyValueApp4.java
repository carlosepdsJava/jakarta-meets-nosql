/*
 * Copyright (c) 2019 Otávio Santana and others
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Apache License v2.0 which accompanies this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Apache License v2.0 is available at http://www.opensource.org/licenses/apache2.0.php.
 *
 * You may elect to redistribute this code under either of these licenses.
 *
 * Contributors:
 *
 * Otavio Santana (@otaviojava)
 * Carlos Santos (@carlosepdsJava)
 */

package jakarta.nosql.demo;


import org.eclipse.jnosql.mapping.DatabaseQualifier;
import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;
import java.util.Optional;

public class KeyValueApp4 {

    public static void main(String[] args) throws InterruptedException {

        try (SeContainer container = SeContainerInitializer
                .newInstance().initialize()) {

            God diana = new God(1L, "Diana", "Hunt");

            GodRepository repository =
                    container.select(GodRepository.class
                    , DatabaseQualifier.ofKeyValue())
                            .get();
            repository.save(diana);
            Optional<God> result = repository.findById(1L);
            System.out.println("Find by id: " + result);
        }
        System.exit(0);
    }
}
