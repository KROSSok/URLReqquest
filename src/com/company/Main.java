package com.company;

public class Main {

    public static void main(String[] args) throws Exception{
	// write your code here
        Config config = new Config();
        config.csvWriter("url");
    }
}

/*
почитай як реквести в джаві робляться
типу GET
потім Наз тобі кине урлу
https://steamcommunity.com/market/priceoverview/?appid=730&currency=3&market_hash_name=StatTrak%E2%84%A2%20M4A1-S%20|%20Hyper%20Beast%20(Minimal%20Wear)
і ти її витягнеш з інету в форматі джейсона і запишеш в файл
https://steamcommunity.com/market/search/render/?search_descriptions=0&sort_column=default&sort_dir=desc&appid=730&norender=1&count=500
https://steamapis.com/
CSV - comma separated values
то дуже простий формат, в екселі працюєш з таким
кароч давай формат такий

<timestamp>,<lowest_price>, <volume>, <median_price>
P250 | Metallic DDPAT
3.50 UAH

бо це буде табличка для статистики, краще такі дані тримати вже по правильному )))
отримуєш джейсон, записуєш дані в таблицю CSV, почитаєш що то
там в тому запиті є іконки, треба конкат замутити
https://steamcommunity-a.akamaihd.net/economy/image/-9a81dlWLwJ2UUGcVs_nsVtzdOEdtWwKGZZLQHTxDZ7I56KU0Zwwo4NUX4oFJZEHLbXU5A1PIYQNqhpOSV-fRPasw8rsUFJ5KBFZv668FFMu1aPMI24auITjxteJwPXxY72AkGgIvZAniLjHpon2jlbl-kpvNjz3JJjVLFG9rl1YLQ/62fx62f
вот кейс)
*/