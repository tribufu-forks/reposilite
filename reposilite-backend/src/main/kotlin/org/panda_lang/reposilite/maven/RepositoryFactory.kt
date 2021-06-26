/*
 * Copyright (c) 2021 dzikoysk
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.panda_lang.reposilite.maven

import org.panda_lang.reposilite.config.Configuration.RepositoryConfiguration
import org.panda_lang.reposilite.maven.api.Repository
import org.panda_lang.reposilite.maven.api.RepositoryVisibility
import org.panda_lang.reposilite.storage.StorageProviderFactory

internal class RepositoryFactory(private val storageProviderFactory: StorageProviderFactory) {

    fun createRepository(repositoryName: String, repositoryConfiguration: RepositoryConfiguration): Repository =
        Repository(
            repositoryName,
            RepositoryVisibility.valueOf(repositoryConfiguration.visibility.toUpperCase()),
            storageProviderFactory.createStorageProvider(repositoryName, repositoryConfiguration.storageProvider),
            repositoryConfiguration.deployEnabled
        )

}