/*
 *
 *  Copyright 2011 Netflix, Inc.
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 *
 */

package com.netflix.curator.x.discovery.strategies;

import com.netflix.curator.x.discovery.details.InstanceProvider;
import com.netflix.curator.x.discovery.ProviderStrategy;
import com.netflix.curator.x.discovery.ServiceInstance;
import java.util.List;
import java.util.Random;

/**
 * This strategy always picks a random instance from the list
 */
public class RandomStrategy<T> implements ProviderStrategy<T>
{
    private final Random            random = new Random();

    @Override
    public ServiceInstance<T> getInstance(InstanceProvider<T> instanceProvider) throws Exception
    {
        List<ServiceInstance<T>>    instances = instanceProvider.getInstances();
        if ( instances.size() == 0 )
        {
            return null;
        }
        int                         thisIndex = random.nextInt(instances.size());
        return instances.get(thisIndex);
    }
}
