/*
 * Copyright (C) 2012 Soomla Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.soomla.store;

import com.soomla.store.domain.NonConsumableItem;
import com.soomla.store.domain.VirtualCategory;
import com.soomla.store.domain.virtualCurrencies.VirtualCurrency;
import com.soomla.store.domain.virtualCurrencies.VirtualCurrencyPack;
import com.soomla.store.domain.virtualGoods.VirtualGood;

/**
 * This interface represents a single game's metadata. Use this interface to create your assets
 * class that will be transferred to StoreInfo upon initialization.
 */
public interface IStoreAssets {

    /** Setters and Getters */

    /**
     * Retrieves the current version of your IStoreAssets.
     *
     * This value will determine if the saved data in the database will be deleted or not.
     * Bump the version every time you want to delete the old data in the DB.
     *
     * Real Game Example:
     *   Suppose that your game has a VirtualGood called "Hat".
     *   Let's say your game's IStoreAssets version is currently 0.
     *   Now you want to change the name "Hat" to "Green Hat" - you will need to bump the version
     *   from 0 to 1, in order for the new name, "Green Hat" to replace the old one, "Hat".
     *
     * Explanation: The local database on every one of your users' devices keeps your economy's
     * metadata, such as the VirtualGood's name "Hat". When you change IStoreAssets, you must bump
     * the version in order for the data to change in your users' local databases.
     *
     * You need to bump the version after ANY change in IStoreAssets for the local database to
     * realize it needs to refresh its data.
     *
     * @return the version of your specific IStoreAssets.
     */
    int getVersion();

    /**
     * Retrieves the array of your game's virtual currencies.
     */
    VirtualCurrency[] getCurrencies();

    /**
     * Retrieves the array of all virtual goods served by your store (all kinds in one array).
     */
    VirtualGood[] getGoods();

    /**
     * Retrieves the array of all virtual currency packs served by your store.
     */
    VirtualCurrencyPack[] getCurrencyPacks();

    /**
     * Retrieves the array of all virtual categories handled in your store.
     */
    VirtualCategory[] getCategories();

    /**
     * Retrieves the array of all non-consumable items served by your store.
     * You can define non-consumable items that you'd like to use for your needs.
     * CONSUMABLE (or UNMANAGED) items are usually just currency packs.
     * NON-CONSUMABLE (or MANAGED) items are usually used to let users purchase a "no-ads" token.
     *
     * NOTE: Make sure you set the type of the items you add here as Managed.MANAGED.
     *
     * @return an array of all non-consumables served in your game.
     */
    NonConsumableItem[] getNonConsumableItems();
}
