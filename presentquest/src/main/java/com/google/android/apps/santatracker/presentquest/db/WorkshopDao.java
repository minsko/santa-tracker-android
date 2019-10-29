/*
 * Copyright (C) 2017 Google Inc. All Rights Reserved.
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

package com.google.android.apps.santatracker.presentquest.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.google.android.apps.santatracker.presentquest.vo.Workshop;

import java.util.List;

@Dao
public interface WorkshopDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertWorkshop(Workshop workshop);

    @Update
    int updateWorkshop(Workshop workshop);

    @Query("DELETE FROM workshop")
    void deleteAll();

    @Query("SELECT * FROM workshop")
    List<Workshop> getAll();

    @Query("SELECT * FROM workshop WHERE id = :id LIMIT 1")
    Workshop findById(long id);

    @Delete
    void delete(Workshop workshop);

    @Query("SELECT * FROM workshop LIMIT 1")
    Workshop getFirst();

    @Query("SELECT * FROM workshop ORDER BY id ASC")
    LiveData<List<Workshop>> getAllNewToOld();
}
