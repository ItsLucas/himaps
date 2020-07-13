<?php


class friend
{
    public String $name;
    public String $phone;

    /**
     * friend constructor.
     * @param String $name
     * @param String $phone
     */
    public function __construct(string $name, string $phone)
    {
        $this->name = $name;
        $this->phone = $phone;
    }
}