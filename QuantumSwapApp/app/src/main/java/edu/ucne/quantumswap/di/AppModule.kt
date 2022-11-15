package edu.ucne.quantumswap.di

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import edu.ucne.quantumswap.data.remote.QuantumSwapApi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideMoshi(): Moshi {
        return Moshi
            .Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }
    @Singleton
    @Provides
    fun providesQuantumSwapApi(moshi: Moshi): QuantumSwapApi {
        return Retrofit.Builder()
            .baseUrl("https://quantumswap.herokuapp.com/")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
            .create(QuantumSwapApi::class.java)
    }
}