<?php


class userloc
{
    public String $user;
    public float $x;
    public float $y;

    /**
     * userloc constructor.
     * @param String $user
     * @param int $x
     * @param int $y
     */
    public function __construct(string $user, float $x, float $y)
    {
        $this->user = $user;
        $this->x = $x;
        $this->y = $y;
    }
}